import { Component, OnInit } from '@angular/core';
import { JwtClientService } from '../../_service/jwt-client.service';
import { UsernameAndPasswordModel } from '../../_model/UsernamePassword.model';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  constructor(private authService: JwtClientService, private router: Router) {}
  authRequest: UsernameAndPasswordModel;

  loginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  login() {
    const val = this.loginForm.value;

    if (val.email && val.password) {
      this.authRequest.password = val.password;
      this.authRequest.userName = val.email;

      this.authService
        .generateToken(this.authRequest)
        .subscribe((data) => console.log('Token :' + data));
    }
  }

  ngOnInit(): void {}
}
