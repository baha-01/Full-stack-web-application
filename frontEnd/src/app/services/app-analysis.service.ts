import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Analysis } from '../models/analysis.model'; // Create this model based on your backend entity

@Injectable({
  providedIn: 'root'
})
export class AppAnalysisService {
  private baseUrl = 'http://localhost:8087/ImmobilierBackend/analysis'; // Update with your backend URL

  constructor(private http: HttpClient) { }

  getAllAnalysis(): Observable<Analysis[]> {
    return this.http.get<Analysis[]>(`${this.baseUrl}`);
  } 

  getAnalysisById(id: number): Observable<Analysis> {

    return this.http.get<Analysis>(`${this.baseUrl}/${id}`);
  }

  createAnalysis(analysis: Analysis): Observable<Analysis> {
    return this.http.post<any>(`${this.baseUrl}`, analysis);
  }

  updateAnalysis(id: number, analysis: Analysis): Observable<Analysis> {
    return this.http.put<Analysis>(`${this.baseUrl}/${id}`, analysis);
  }

  deleteAnalysis(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
