import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Person } from '../model/person.model';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  URLPersons = 'https://backendnv.herokuapp.com/persons/';

  constructor(private http: HttpClient) { }

  public getPerson(): Observable<Person> {
    return this.http.get<Person>(this.URLPersons + 'get/profile');
  }

  public detail(id: number): Observable<Person> {
    return this.http.get<Person>(this.URLPersons + `detail/${id}`);
  }

  public update(id: number, Person: Person): Observable<any> {
    return this.http.put<any>(this.URLPersons + `update/${id}`, Person);
  }
}
