import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/model/project';
import { ProjectServiceService } from 'src/app/services/project-service.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  project: Project[] = [];

  constructor(private proService: ProjectServiceService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadProjects();

    if(this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadProjects() {
    this.proService.list().subscribe(data => { this.project = data })
  }

  delete(id?: number) {
    let deleteProject = confirm("Está seguro que desea eliminar este proyecto?");

    if (deleteProject ) {
      if (id !== undefined) {
        this.proService.delete(id).subscribe(data => this.loadProjects());
      } else {
        alert("Error al eliminar el proyecto seleccionado.")
      }
    }
  }
}
