import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './layout/login/login.component';
import { HomeComponent } from './layout/home/home.component';
import { AuthGuard } from './_helper/auth.guard';
import { QuestionsComponent } from './layout/questions/questions.component';
import { QuestionsResolver } from './_resolver/questions.resolver';

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  {
    path: 'questions',
    component: QuestionsComponent,
    resolve: { ques: QuestionsResolver },
  },
  { path: 'login', component: LoginComponent },

  // otherwise redirect to home
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [QuestionsResolver],
})
export class AppRoutingModule {}
