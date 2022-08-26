import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { ExpServiceService } from 'src/app/services/exp-service.service';

@Component({
  selector: 'app-edit-experience',
  templateUrl: './edit-experience.component.html',
  styleUrls: ['./edit-experience.component.css']
})
export class EditExperienceComponent implements OnInit {
  experience: Experience = null;
  constructor(
    private expService: ExpServiceService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.expService.detail(id).subscribe(data => {
      this.experience = data;
    }, err => {
      alert("Error al editar la experiencia.");
      this.router.navigate(['']);
    });
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.expService.update(id, this.experience).subscribe(data => {
      this.router.navigate(['']);
    }, err => {
      alert("Error al editar la experiencia.");
      this.router.navigate(['']);
    });
  }

}
