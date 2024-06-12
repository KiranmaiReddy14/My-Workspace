import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginuserService {
  private baseUrl = "http://localhost:8080/login";
  constructor(private http: HttpClient) { }

  loginUser(userId: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('userId', userId)
      .set('password', password);
    return this.http.get(this.baseUrl, { params });
  }
}
