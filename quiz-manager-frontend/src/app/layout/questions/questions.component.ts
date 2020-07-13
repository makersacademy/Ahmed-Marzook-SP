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
import { atLeastOneCheckboxCheckedValidator } from 'src/app/_validators/atLeastOneCheckBox';

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
    private fb: FormBuilder
  ) {
    this.authenticationService.currentUser.subscribe(
      (x) => (this.currentUser = x)
    );
  }

  buildQuestionForm(question: Question): FormGroup {
    const questionFormGroup = new FormGroup({});
    question.answers.forEach((answer) => {
      questionFormGroup.addControl(answer.answerTitle, this.fb.control(false));
    });
    return questionFormGroup;
  }

  buildQuizForm(): FormGroup {
    const quizForm = this.fb.group({}, {});
    this.questions.forEach((question) => {
      quizForm.addControl(
        question.questionTitle,
        this.buildQuestionForm(question)
      );
    });
    return quizForm;
  }

  // buildQuestion() {
  //   const group = this.fb.group({}, {});
  //   this.questions.forEach((question) => {
  //     const questionGroup = this.fb.group({});
  //     question.answers.forEach((answer) => {
  //       questionGroup.addControl(answer.answerTitle, this.fb.control('', {}));
  //     });
  //     group.addControl(question.questionTitle, questionGroup);
  //   });
  //   console.log(group);
  //   return group;
  // }

  ngOnInit(): void {
    this.questions = this.route.snapshot.data.ques;

    const quizlist: Quiz[] = JSON.parse(localStorage.getItem('quizList'));
    this.quiz = quizlist.find(
      (data) => data.quizId === +this.route.snapshot.paramMap.get('id')
    );

    this.quizForm = this.buildQuizForm();
  }

  onSubmit(): void {
    console.log(this.quizForm.value);
  }
}
