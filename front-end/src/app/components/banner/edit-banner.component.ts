import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from 'src/app/model/person.model';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-edit-banner',
  templateUrl: './edit-banner.component.html',
  styleUrls: ['./edit-banner.component.css']
})
export class EditBannerComponent implements OnInit {
  Person: Person = null;

  constructor(
    private personService: PersonService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.personService.detail(id).subscribe(data => {
      this.Person = data
    }, err => {
      alert(err.error.msg || "Error al editar el banner.");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.personService.update(id, this.Person).subscribe(data => {
      this.router.navigate(['']);
    }, err => {
      alert(err.error.msg || "Error al editar el banner.");
      this.router.navigate(['']);
    })
  }
}
