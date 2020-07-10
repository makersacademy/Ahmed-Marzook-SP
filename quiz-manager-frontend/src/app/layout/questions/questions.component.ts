import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.scss'],
})
export class QuestionsComponent implements OnInit {
  questions: any;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.questions = this.route.snapshot.data;
  }
}
