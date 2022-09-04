import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectServiceService {
urlProjects = 'https://backendnv.herokuapp.com/projects/';
  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Project[]> {
    return this.httpClient.get<Project[]>(this.urlProjects + 'list');
  }

  public detail(id: number): Observable<Project> {
    return this.httpClient.get<Project>(this.urlProjects + `detail/${id}`);
  }

  public save(project: Project): Observable<any> {
    return this.httpClient.post<any>(this.urlProjects + 'create', project);
  }

  public update(id: number, project: Project): Observable<any> {
    return this.httpClient.put<any>(this.urlProjects + `update/${id}`, project);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.urlProjects + `delete/${id}`);
  }
}
