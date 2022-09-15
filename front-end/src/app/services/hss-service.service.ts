import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HSS } from '../model/hss';

@Injectable({
  providedIn: 'root'
})
export class HssServiceService {
  urlSkills = 'https://backendnv.herokuapp.com/skills/';

  constructor(private httpCllient: HttpClient) { }

  public list(): Observable<HSS[]> {
    return this.httpCllient.get<HSS[]>(this.urlSkills + 'list');
  }

  public detail(id: number): Observable<HSS> {
    return this.httpCllient.get<HSS>(this.urlSkills + `detail/${id}`);
  }

  public save(hss: HSS): Observable<any> {
    return this.httpCllient.post<any>(this.urlSkills + "create", hss);
  }

  public update(id: number, hss: HSS): Observable<any> {
    return this.httpCllient.put<any>(this.urlSkills + `update/${id}`, hss);
  }

  public delete(id: number): Observable<any> {
    return this.httpCllient.delete<any>(this.urlSkills + `delete/${id}`);
  }
}
