/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.gui;

import ca.weblite.codename1.components.charts.ChartView;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.charts.*;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.soukelmdina.app.MyApplication;
import com.soukelmdina.service.ServiceBoutique;

/**
 *
 * @author lina9
 */
public class PieChartt extends Layout{

    public Form PieChartt(int k) {
        
        ServiceBoutique sb = new ServiceBoutique();           
        // Generate the values
        double[] values = new double[]{sb.Like(k), sb.DisLike(k)};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.rgb(0, 51, 0), ColorUtil.rgb(202, 16, 16)};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(10);        
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        SimpleSeriesRenderer rr = renderer.getSeriesRendererAt(1);
        
        r.setGradientEnabled(true);        
        r.setGradientStart(0, ColorUtil.rgb(0, 51, 0));
        r.setGradientStop(0, ColorUtil.rgb(141, 243, 158));
        r.setHighlighted(true);
        
        rr.setGradientEnabled(true);
        rr.setGradientStart(0, ColorUtil.rgb(202, 16, 16));
        rr.setGradientStop(0, ColorUtil.rgb(255, 102, 102));
        rr.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.        
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
     
        
        
        toolbar.add(BorderLayout.CENTER, new Label("piechart"));
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        
        f.getAllStyles().setBgImage(MyApplication.theme.getImage("back_2.jpg"));
        f.addComponent(c);
        return f;
        
    }
    
    
     private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        //renderer.setLabelsColor(ColorUtil.rgb(0, 0, 0));
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }
     
     
     /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        /*int k = 0;
        for (double value : values) {
            series.add("Project " + ++k, value);
        }*/
        series.add("nbL", values[0]);            
        series.add("nbD", values[1]);

        return series;
    }
    
    
    
}
