import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { AnalysisService } from '../../services/analysis.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { AppAnalysisService } from '../../services/app-analysis.service';

@Component({
  selector: 'app-analysis-detail',
  templateUrl: './analysis-detail.component.html',
  standalone:true,
  imports:[CommonModule,RouterLink,ReactiveFormsModule],
  styleUrls: ['./analysis-detail.component.css']
})
export class AnalysisDetailComponent implements OnInit {
  analysis:any;

  constructor(
    private route: ActivatedRoute,
    private analysisService: AppAnalysisService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      this.analysisService.getAnalysisById(+id).subscribe(data => {
        this.analysis = data;
      });
    }
  }
}
