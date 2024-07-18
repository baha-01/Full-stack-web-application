import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Analysis } from '../models/analysis.model';

@Injectable({
  providedIn: 'root'
})
export class AnalysisService {
  private baseUrl = 'http://localhost:8087/ImmobilierBackend/analysis/create';

  constructor(private http: HttpClient) {}

  getAllAnalysis(): Observable<Analysis[]> {
    return this.http.get<Analysis[]>(this.baseUrl);
  }

  getAnalysisById(id: number): Observable<Analysis> {
    return this.http.get<Analysis>(`${this.baseUrl}/${id}`);
  }

  createAnalysis(analysis: any): Observable<Analysis> {
    console.log(this.baseUrl)
    console.log(analysis)
    return this.http.post<any>(this.baseUrl, analysis);
  }

  updateAnalysis(id: number, analysis: Analysis): Observable<Analysis> {
    return this.http.put<Analysis>(`${this.baseUrl}/${id}`, analysis);
  }

  deleteAnalysis(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
