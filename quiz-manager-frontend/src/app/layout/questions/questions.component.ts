import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Question } from 'src/app/_model/question.model';
import { AuthenticationService } from 'src/app/_service/authentication.service';
import { User } from 'src/app/_model/quiz-user.model';
import { Quiz } from '../../_model/quiz.model';
import {
  FormBuilder,
  FormGroup,
  FormArray,
  Validators,
  FormControl,
} from '@angular/forms';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.scss'],
})
export class QuestionsComponent implements OnInit {
  quiz: Quiz;
  questions: Question[];
  currentUser: User;
  quizForm: FormGroup;
  submitted = false;

  constructor(
    private route: ActivatedRoute,
    private authenticationService: AuthenticationService,
    private formBuilder: FormBuilder
  ) {
    this.authenticationService.currentUser.subscribe(
      (x) => (this.currentUser = x)
    );
  }

  ngOnInit(): void {
    let group = {};
    this.questions = this.route.snapshot.data.ques;

    const quizlist: Quiz[] = JSON.parse(localStorage.getItem('quizList'));
    this.quiz = quizlist.find(
      (data) => data.quizId === +this.route.snapshot.paramMap.get('id')
    );

    this.questions.forEach((question) => {
      question.answers.forEach((answer) => {
        group[answer.answerTitle] = new FormControl('');
      });
    });
    this.quizForm = new FormGroup(group);
  }
}
