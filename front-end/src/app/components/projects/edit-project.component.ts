import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from 'src/app/model/project';
import { ProjectServiceService } from 'src/app/services/project-service.service';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit {
  project: Project = null;
  constructor(
    private proService: ProjectServiceService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.proService.detail(id).subscribe(data => {
      this.project = data;
    }, err => {
      alert(err.error.msg || "Error al editar el proyecto.");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.proService.update(id, this.project).subscribe(data => {
      this.router.navigate(['']);
      }, err => {
        alert(err.error.msg || "Error al editar el proyecto.");
        this.router.navigate(['']);
      })
  }

}
