import { Component } from '@angular/core';
import { ToDo } from './models/to-do';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-todo-list-tracker';
  selected = true;
  todo: ToDo[] = [];
  index = 1;
  statusvalue = "";
  to: ToDo = new ToDo;
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
