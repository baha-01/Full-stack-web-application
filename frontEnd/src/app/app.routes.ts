import { Routes } from '@angular/router';
import { AnalysisListComponent } from './pages/analysis-list/analysis-list.component';
import { AnalysisCreateComponent } from './pages/analysis-create/analysis-create.component';
import { AnalysisDetailComponent } from './pages/analysis-detail/analysis-detail.component';

export const routes: Routes = [
    { path: '', redirectTo: 'analysis-list', pathMatch: 'full' },
    { path: 'analysis-list', component: AnalysisListComponent },
    { path: 'create-analysis', component: AnalysisCreateComponent },
    { path: 'analysis-detail/:id', component: AnalysisDetailComponent },
    // Add more routes as needed
  ];