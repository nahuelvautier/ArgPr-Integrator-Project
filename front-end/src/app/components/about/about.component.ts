import { Component, OnInit } from '@angular/core';
import { Person } from '../../model/person.model';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  Person: Person = new Person("", "", "");

  constructor(public personService: PersonService) { }

  ngOnInit(): void {
    this.personService.getPerson()
      .subscribe((data) => {
        this.Person = data
      });
  }

}
