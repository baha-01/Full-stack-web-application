import { Component, OnInit } from '@angular/core';
import { AnalysisService } from '../../services/analysis.service';
import { Analysis } from '../../models/analysis.model';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { AppAnalysisService } from '../../services/app-analysis.service';

@Component({
  selector: 'app-analysis-list',
  standalone:true,
  imports:[CommonModule,RouterLink,ReactiveFormsModule],
  templateUrl: './analysis-list.component.html',
  styleUrls: ['./analysis-list.component.css']
})
export class AnalysisListComponent implements OnInit {
  analyses: Analysis[] = [];

  constructor(private analysisService: AppAnalysisService) {}

  ngOnInit(): void {
    this.analysisService.getAllAnalysis().subscribe(data => {
      this.analyses = data;
    });
  }
}
