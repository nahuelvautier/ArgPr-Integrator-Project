import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationServiceService } from 'src/app/services/education-service.service';

@Component({
  selector: 'app-edit-education',
  templateUrl: './edit-education.component.html',
  styleUrls: ['./edit-education.component.css']
})
export class EditEducationComponent implements OnInit {
  education: Education = null;
  constructor(
    private eduService: EducationServiceService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.eduService.detail(id).subscribe(data => {
      this.education = data;
    }, err => {
      alert("Error al editar la educación");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.eduService.update(id, this.education).subscribe(data => {
      this.router.navigate(['']);
    }, err => {
      alert("Error al editar la educación");
      this.router.navigate(['']);
    })
  }
}
