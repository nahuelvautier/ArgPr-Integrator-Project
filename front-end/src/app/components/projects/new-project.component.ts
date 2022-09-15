import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from 'src/app/model/project';
import { ProjectServiceService } from 'src/app/services/project-service.service';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {
  proName: string;
  proDescription: string;
  proApiUsed: string;
  proExpedition: string;
  proHref: string;

  constructor(private proService: ProjectServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const project = new Project(
      this.proName,
      this.proDescription,
      this.proApiUsed,
      this.proExpedition,
      this.proHref
    );

    this.proService.save(project).subscribe(data => {
      alert("Proyecto añadido con éxito.");
      this.router.navigate(['']);
    }, err => {
      alert(err.error.msg || "Error al añadir el proyecto.");
    })
  }
}
