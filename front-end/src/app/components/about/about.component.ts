import { Component, OnInit } from '@angular/core';
import { Person } from '../../model/person.model';
import { PersonService } from 'src/app/services/person.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  Person: Person = new Person("", "", "", "", "");

  constructor(public personService: PersonService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadProfile();

    if(this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadProfile(): void {
    this.personService.getPerson().subscribe((data) => { this.Person = data });
  }
}
