import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../_service/authentication.service';
import { User } from '../../_model/quiz-user.model';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;
  loading = false;
  returnUrl: string;
  error = '';

  constructor(
    private authenticationService: AuthenticationService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  get f() {
    return this.loginForm.controls;
  }

  login() {
    console.log('Here I am');
    this.submitted = true;

    if (this.loginForm.invalid) {
      return;
    }

    this.authenticationService
      .login(this.f.email.value, this.f.password.value)
      .pipe(first())
      .subscribe(
        (data) => {
          this.router.navigate([this.returnUrl]);
        },
        (error) => {
          this.error = error;
          this.loading = false;
        }
      );
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl(''),
      password: new FormControl(''),
    });
    this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';
  }
}
