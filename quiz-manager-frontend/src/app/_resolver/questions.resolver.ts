import { Injectable } from '@angular/core';
import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { QuestionsService } from '../_service/questions.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class QuestionsResolver implements Resolve<any> {
  constructor(
    private http: HttpClient,
    private questionsService: QuestionsService
  ) {}

  resolve(route: ActivatedRouteSnapshot): Observable<any> {
    return this.questionsService.getQuestionsForQuiz(route.paramMap.get('id'));
  }
}
