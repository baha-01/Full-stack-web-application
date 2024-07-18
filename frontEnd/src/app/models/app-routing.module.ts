import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnalysisListComponent } from '../analysis-list/analysis-list.component';
import { AnalysisCreateComponent } from '../analysis-create/analysis-create.component';
import { AnalysisDetailComponent } from '../analysis-detail/analysis-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'analysis-list', component: AnalysisListComponent },
  { path: 'create-analysis', component: AnalysisCreateComponent },
  { path: 'analyses/:id', component: AnalysisDetailComponent },
  // Add more routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
