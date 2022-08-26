import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experience } from '../model/experience';

@Injectable({
  providedIn: 'root'
})
export class ExpServiceService {
  urlEXP = 'https://backendnv.herokuapp.com/experience/'

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Experience[]> {
    return this.httpClient.get<Experience[]>(this.urlEXP + 'list');
  }

  public detail(id: number): Observable<Experience> {
    return this.httpClient.get<Experience>(this.urlEXP+ `detail/${id}`);
  }

  public save(experience: Experience): Observable<any> {
    return this.httpClient.post<any>(this.urlEXP + 'create', experience);
  }

  public update(id: number, experience: Experience): Observable<any> {
    return this.httpClient.put<any>(this.urlEXP + `update/${id}`, experience);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.urlEXP + `delete/${id}`);
  }
}
