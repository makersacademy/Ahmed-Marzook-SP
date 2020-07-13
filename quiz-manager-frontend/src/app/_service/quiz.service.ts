import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Quiz } from '../_model/quiz.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class QuizService {
  constructor(private http: HttpClient) {}

  getQuizes(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(`${environment.apiUrl}/quiz/allQuiz`);
  }

  postQuiz(quiz: Quiz): any {
    this.http.post(`${environment.apiUrl}/quiz/addQuiz`, quiz).subscribe({
      error: (error) => console.error('There was an error!', error),
    });
  }

  deleteQuiz(id: string) {
    const params = new HttpParams().set('id', id);
    return this.http
      .get(`${environment.apiUrl}/quiz/delete-quiz/`, { params })
      .subscribe({
        error: (error) => console.error('There was an error!', error),
      });
  }
}
