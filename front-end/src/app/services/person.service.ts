import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Person } from '../model/person.model';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  URLbase = 'http://localhost:8080/persons/';

  constructor(private http: HttpClient) { }

  public getPerson() : Observable<Person> {
    return this.http.get<Person>(this.URLbase + 'get/profile');
  }
}
