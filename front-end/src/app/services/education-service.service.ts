import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Education } from '../model/education';

@Injectable({
  providedIn: 'root'
})
export class EducationServiceService {
  urlEducation = 'https://backendnv.herokuapp.com/education/';
  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Education[]> {
    return this.httpClient.get<Education[]>(this.urlEducation + 'list');
  }

  public detail(id: number): Observable<Education> {
    return this.httpClient.get<Education>(this.urlEducation + `detail/${id}`);
  }

  public save(education: Education): Observable<any> {
    return this.httpClient.post<any>(this.urlEducation + 'create', education);
  }

  public update(id: number, education: Education): Observable<any> {
    return this.httpClient.put<any>(this.urlEducation + `update/${id}`, education);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.urlEducation + `delete/${id}`);
  }
}
