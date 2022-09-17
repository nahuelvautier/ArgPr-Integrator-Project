import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from 'src/app/model/person.model';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-edit-about',
  templateUrl: './edit-about.component.html',
  styleUrls: ['./edit-about.component.css']
})
export class EditAboutComponent implements OnInit {
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
      alert(err.error.msg || "Error al editar la información.");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.personService.update(id, this.Person).subscribe(data => {
      this.router.navigate(['']);
    }, err => {
      alert(err.error.msg || "Error al editar la información.");
      this.router.navigate(['']);
    })
  }
}
