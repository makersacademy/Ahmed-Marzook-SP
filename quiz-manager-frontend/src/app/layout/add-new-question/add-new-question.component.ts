import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/_service/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';
import { QuizService } from 'src/app/_service/quiz.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { QuestionsService } from 'src/app/_service/questions.service';
import { Answer } from 'src/app/_model/answer.model';
import { Question } from 'src/app/_model/question.model';
import { Quiz } from 'src/app/_model/quiz.model';

@Component({
  selector: 'app-add-new-question',
  templateUrl: './add-new-question.component.html',
  styleUrls: ['./add-new-question.component.scss'],
})
export class AddNewQuestionComponent implements OnInit {
  addQuestionForm: FormGroup;
  quiz: Quiz;
  constructor(
    private authenticationService: AuthenticationService,
    private route: ActivatedRoute,
    private router: Router,
    private questionService: QuestionsService
  ) {}

  get f() {
    return this.addQuestionForm.controls;
  }

  ngOnInit(): void {
    const quizlist: Quiz[] = JSON.parse(localStorage.getItem('quizList'));
    this.quiz = quizlist.find(
      (data) => data.quizId === +this.route.snapshot.paramMap.get('id')
    );

    this.addQuestionForm = new FormGroup({
      questionTitle: new FormControl('', Validators.required),
      answerOne: new FormControl('', Validators.required),
      answerTwo: new FormControl('', Validators.required),
      answerThree: new FormControl('', Validators.required),
      answerFour: new FormControl('', Validators.required),
      answerOneCorrect: new FormControl(''),
      answerTwoCorrect: new FormControl(''),
      answerThreeCorrect: new FormControl(''),
      answerFourCorrect: new FormControl(''),
    });
  }

  onSubmit() {
    if (this.addQuestionForm.invalid) {
      return;
    }
    const question = new Question();
    question.questionTitle = this.f.questionTitle.value;
    let answersArray: Answer[];
    const answerOne = new Answer();
    answerOne.answerTitle = this.f.answerOne.value;
    answerOne.correct = this.f.answerOneCorrect.value;
    const answerTwo = new Answer();
    answerTwo.answerTitle = this.f.answerTwo.value;
    answerTwo.correct = this.f.answerTwoCorrect.value;
    const answerThree = new Answer();
    answerThree.answerTitle = this.f.answerThree.value;
    answerThree.correct = this.f.answerThreeCorrect.value;
    const answerFour = new Answer();
    answerFour.answerTitle = this.f.answerFour.value;
    answerFour.correct = this.f.answerFourCorrect.value;
    answersArray = [answerOne, answerTwo, answerThree, answerFour];
    question.answers = answersArray;
    question.quizId = this.quiz.quizId;
    console.log(question);
  }
}
