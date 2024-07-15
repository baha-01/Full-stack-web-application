import { Component, OnInit } from '@angular/core';
import { AnalysisService } from 'C:\Users\sedki.bani\Desktop\Full-stack-web-application\backEnd\src\main\java\tn\esprit\backend\service\AnalysisService.java';

@Component({
  selector: 'app-analysis-list',
  templateUrl: './analysis-list.component.html',
  styleUrls: ['./analysis-list.component.css']
})
export class AnalysisListComponent implements OnInit {
  analyses: Analysis[];

  constructor(private analysisService: AnalysisService) { }

  ngOnInit(): void {
    this.analysisService.getAllAnalysis().subscribe(data => {
      this.analyses = data;
    });
  }
}
