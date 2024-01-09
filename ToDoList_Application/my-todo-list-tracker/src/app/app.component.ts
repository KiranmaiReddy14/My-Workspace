import { Component, OnInit } from '@angular/core';
import { ToDo } from './models/to-do';
import { TodoServiceService } from './service/todo-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'my-todo-list-tracker';
  selected = true;
  todo: ToDo[] = [];
  index = 1;
  statusvalue = "";
  to: ToDo = new ToDo;

  constructor(private todoService: TodoServiceService) {}
  
  ngOnInit() {
    this.todoService.findAll().subscribe(todo => {
      console.log("abcbcbc")
      console.log(todo);
      this.todo = todo;
    });
    console.log(this.todo)
  }

  addNewTask() {
    this.selected = !this.selected;
  }
  addTask(taskName: any, status: any) {
    this.to = new ToDo;
    this.to.taskName = taskName;
    console.log(this.statusvalue)
    this.to.status = this.statusvalue;
    this.todo.push(this.to);
    this.selected = !this.selected;
  }
  statusChange(s: any) {
    this.statusvalue = s.target.defaultValue;
  }
}
