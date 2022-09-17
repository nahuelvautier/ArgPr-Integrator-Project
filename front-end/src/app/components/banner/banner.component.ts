import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/model/person.model';
import { PersonService } from 'src/app/services/person.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {
  Person: Person = new Person("", "", "", "", "");

  constructor(private personService: PersonService, private tokenService: TokenService) { }

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
