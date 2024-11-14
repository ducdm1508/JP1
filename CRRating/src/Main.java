import Entity.CRStatistics;
import Entity.StatisticsView;
import Service.FileService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String fileInPathStatistics = System.getProperty("user.dir").replace("/","\\") + "/data/statistics.view.txt";
        FileService fileService = new FileService();
        List<StatisticsView> statisticsViews = fileService.readFileStatistics(fileInPathStatistics);

        Map<CRStatistics, CRStatistics> dataCRS = statisticsViews.stream()
                .collect(Collectors.groupingBy(
                        cr -> new CRStatistics(cr.getId(),cr.getMonthOfDate(), cr.getYearOfDate()),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                listCr ->{
                                    CRStatistics crStatistics = new CRStatistics();
                                    StatisticsView firtStatistics = listCr.getFirst();
                                    int toalView = listCr.stream().mapToInt(StatisticsView::getView).sum();
                                    crStatistics.setId(firtStatistics.getId());
                                    crStatistics.setMonth(firtStatistics.getMonthOfDate());
                                    crStatistics.setYear(firtStatistics.getYearOfDate());
                                    crStatistics.setTotalView(toalView);
                                    crStatistics.setTotalAddToCard(listCr.stream().mapToInt(StatisticsView::getAddToCart).sum());
                                    crStatistics.setTotalCheckOut(listCr.stream().mapToInt(StatisticsView::getCheckOut).sum());
                                    return crStatistics;
                                }
                        )
                ));

        dataCRS.forEach((k,v) -> System.out.println(v));
    }
}