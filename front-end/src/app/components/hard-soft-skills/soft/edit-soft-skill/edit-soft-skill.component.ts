import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HSS } from 'src/app/model/hss';
import { HssServiceService } from 'src/app/services/hss-service.service';

@Component({
  selector: 'app-edit-soft-skill',
  templateUrl: './edit-soft-skill.component.html',
  styleUrls: ['./edit-soft-skill.component.css']
})
export class EditSoftSkillComponent implements OnInit {
  hss: HSS = null;
  constructor(
    private hssService: HssServiceService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.hssService.detail(id).subscribe(data => {
      this.hss = data
    }, err => {
      alert(err.error.msg || "Error al editar la habilidad.");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void {

    if (!this.hss.hsTitle) {
      throw {
        alert: alert("El nombre de la habilidad es requerido."),
        navigate: this.router.navigate([''])
      }
      return null;
    } else {
      const id = this.activatedRoute.snapshot.params['id'];
      this.hssService.update(id, this.hss).subscribe(data => {
        this.router.navigate(['']);
      }, err => {
        alert(err.error.msg || "Error al editar la habilidad.");
        this.router.navigate(['']);
      })
    }

  }
}
