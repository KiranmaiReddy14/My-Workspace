import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginuserService {
  private baseUrl = "htp://localhost:8080/user/login";
  constructor(private http: HttpClient) { }

  loginUser(user: User): Observable<object> {
    console.log(user);
    return this.http.post(`{$this.baseUrl}`, user);
  }
}
