import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AnalysisService } from '../analysis.service';
import { Analysis } from '../analysis.model';

@Component({
  selector: 'app-analysis-detail',
  templateUrl: './analysis-detail.component.html',
  styleUrls: ['./analysis-detail.component.css']
})
export class AnalysisDetailComponent implements OnInit {
  analysis: Analysis;

  constructor(
    private route: ActivatedRoute,
    private analysisService: AnalysisService
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.analysisService.getAnalysisById(id).subscribe(data => {
      this.analysis = data;
    });
  }
}
