import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ToDo } from '../models/to-do';

@Injectable({
  providedIn: 'root'
})
export class TodoServiceService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/getList';
  }

  public findAll(): Observable<ToDo[]> {
    return this.http.get<ToDo[]>(this.url);
  }

  public saveToDo(todo: ToDo) {
    return this.http.post<ToDo>(this.url, todo);
  }
  
}
