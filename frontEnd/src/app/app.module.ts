import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnalysisListComponent } from './analysis-list/analysis-list.component';
import { AnalysisDetailComponent } from './analysis-detail/analysis-detail.component';
import { AnalysisFormComponent } from './analysis-form/analysis-form.component';
import { AnalysisService } from './analysis.service';

@NgModule({
  declarations: [
    AppComponent,
    AnalysisListComponent,
    AnalysisDetailComponent,
    AnalysisFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AnalysisService],
  bootstrap: [AppComponent]
})
export class AppModule { }
