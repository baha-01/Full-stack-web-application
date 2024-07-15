import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnalysisListComponent } from './analysis-list/analysis-list.component';
import { AnalysisDetailComponent } from './analysis-detail/analysis-detail.component';
import { AnalysisFormComponent } from './analysis-form/analysis-form.component';

const routes: Routes = [
  { path: 'analysis', component: AnalysisListComponent },
  { path: 'analysis/new', component: AnalysisFormComponent },
  { path: 'analysis/:id', component: AnalysisDetailComponent },
  { path: 'analysis/:id/edit', component: AnalysisFormComponent },
  { path: '', redirectTo: '/analysis', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
