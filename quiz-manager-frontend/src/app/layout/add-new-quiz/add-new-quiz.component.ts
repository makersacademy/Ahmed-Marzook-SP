import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/_service/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';
import { QuizService } from 'src/app/_service/quiz.service';
import { Quiz } from 'src/app/_model/quiz.model';

@Component({
  selector: 'app-add-new-quiz',
  templateUrl: './add-new-quiz.component.html',
  styleUrls: ['./add-new-quiz.component.scss'],
})
export class AddNewQuizComponent implements OnInit {
  quizForm: FormGroup;
  constructor(
    private authenticationService: AuthenticationService,
    private route: ActivatedRoute,
    private router: Router,
    private quizService: QuizService
  ) {}

  get f() {
    return this.quizForm.controls;
  }

  ngOnInit(): void {
    this.quizForm = new FormGroup({
      quizTitle: new FormControl('', Validators.required),
      quizDescription: new FormControl('', Validators.required),
    });
  }

  onSubmit() {
    if (this.quizForm.invalid) {
      return;
    }

    const quiz = new Quiz();
    quiz.description = this.f.quizDescription.value;
    quiz.title = this.f.quizTitle.value;
    this.quizService.postQuiz(quiz);
    this.quizForm.reset;
  }
}
