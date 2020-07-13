import { Answer } from '../_model/answer.model';

export class Question {
  questionId: number;
  questionTitle: string;
  answers: Answer[];
  quizId: number;
}
