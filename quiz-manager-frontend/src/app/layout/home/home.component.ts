import { Component, OnInit } from '@angular/core';
import { QuizService } from '../../_service/quiz.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  constructor(private quizService: QuizService) {}
  quizList: any;

  ngOnInit(): void {
    this.quizService.getQuizes().subscribe((data) => (this.quizList = data));
  }
}
