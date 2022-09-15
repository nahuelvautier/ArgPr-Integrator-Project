import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewHardSkillComponent } from './new-hard-skill.component';

describe('NewHardSkillComponent', () => {
  let component: NewHardSkillComponent;
  let fixture: ComponentFixture<NewHardSkillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewHardSkillComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewHardSkillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
