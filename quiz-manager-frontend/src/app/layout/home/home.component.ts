import { Component, OnInit } from '@angular/core';
import { QuizService } from '../../_service/quiz.service';
import { User } from '../../_model/quiz-user.model';
import { Quiz } from '../../_model/quiz.model';
import { AuthenticationService } from '../../_service/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  currentUser: User;
  quizList: Quiz[];

  constructor(
    private quizService: QuizService,
    private authenticationService: AuthenticationService,
    private router: Router
  ) {
    this.authenticationService.currentUser.subscribe(
      (x) => (this.currentUser = x)
    );
  }

  ngOnInit(): void {
    this.quizService.getQuizes().subscribe((data) => {
      this.quizList = data;
      localStorage.setItem('quizList', JSON.stringify(this.quizList));
    });
  }

  deleteQuiz(id) {
    this.quizService.deleteQuiz(id);
    window.location.reload();
  }
}
