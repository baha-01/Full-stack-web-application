import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AppAnalysisService } from '../../services/app-analysis.service';
import { Analysis } from '../../models/analysis.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-analysis-create',
  standalone:true,
  imports:[CommonModule,RouterLink,ReactiveFormsModule,],
  templateUrl: './analysis-create.component.html',
  styleUrls: ['./analysis-create.component.css']
})
export class AnalysisCreateComponent implements OnInit {
  analysisForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private analysisService: AppAnalysisService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.analysisForm = this.fb.group({
      analysisId: ['', Validators.required],
      report: ['', Validators.required],
      dateGenerated: ['', Validators.required],
      user: [null]
    });
  }

  saveAnalysis(): void {
    if (this.analysisForm.valid) {
      const analysis: any = this.analysisForm.value;
      console.log("this analysis",analysis)
      this.analysisService.createAnalysis(analysis).subscribe(() => {
        this.router.navigate(['/analysis-list']);
      });
    }
  }
}
