import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class JwtClientService {
  constructor(private http: HttpClient) {}

  /**
   * generateToken
   */
  public generateToken(request) {
    return this.http
      .post<any>('http://quiz_management_backend:8085/authenticate', request, {
        responseType: 'text' as 'json',
      }).
  }

  private setSession(authResult) {
    localStorage.setItem('id_token', authResult.idToken);
  }

  public welcome(token) {
    const tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get('http://quiz_management_backend:8085/message', {
      headers,
      responseType: 'text' as 'json',
    });
  }
}
