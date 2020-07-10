import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Question } from '../_model/question.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class QuestionsService {
  constructor(private http: HttpClient) {}

  getQuestionsForQuiz(id: string): Observable<Question[]> {
    const params = new HttpParams().set('id', id);
    return this.http.get<Question[]>(`${environment.apiUrl}/questions`, {
      params,
    });
  }
}
