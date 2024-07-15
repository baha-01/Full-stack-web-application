import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AnalysisService } from '../analysis.service';
import { Analysis } from '../analysis.model';

@Component({
  selector: 'app-analysis-form',
  templateUrl: './analysis-form.component.html',
  styleUrls: ['./analysis-form.component.css']
})
export class AnalysisFormComponent implements OnInit {
  analysis: Analysis = new Analysis();
  analysisId: number;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private analysisService: AnalysisService
  ) { }

  ngOnInit(): void {
    this.analysisId = +this.route.snapshot.paramMap.get('id');
    if (this.analysisId) {
      this.analysisService.getAnalysisById(this.analysisId).subscribe(data => {
        this.analysis = data;
      });
    }
  }

  save(): void {
    if (this.analysisId) {
      this.analysisService.updateAnalysis(this.analysisId, this.analysis).subscribe(() => {
        this.router.navigate(['/analyses']);
      });
    } else {
      this.analysisService.createAnalysis(this.analysis).subscribe(() => {
        this.router.navigate(['/analyses']);
      });
    }
  }
}
