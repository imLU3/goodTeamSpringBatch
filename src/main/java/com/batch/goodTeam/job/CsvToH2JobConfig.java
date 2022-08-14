package com.batch.goodTeam.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.batch.goodTeam.entity.MyUser;

//@Configuration
//@EnableBatchProcessing
public class CsvToH2JobConfig {
//	@Bean
//    public Job CsvToH2Job(JobBuilderFactory jobBuilderFactory,
//                   StepBuilderFactory stepBuilderFactory,
//                   ItemReader<MyUser> itemReader,
//                   ItemProcessor<MyUser, MyUser> itemProcessor,
//                   ItemWriter<MyUser> itemWriter
//    ) {
//
//        Step step = stepBuilderFactory.get("CsvToH2Step")
//                .<MyUser, MyUser>chunk(100)
//                .reader(itemReader)
//                .processor(itemProcessor)
//                .writer(itemWriter)
//                .build();
//
//
//        return jobBuilderFactory.get("CsvToH2Job")
//                .incrementer(new RunIdIncrementer())
//                .start(step)
//                .build();
//    }
//
//    @Bean
//    public FlatFileItemReader<MyUser> itemReader() {
//
//        FlatFileItemReader<MyUser> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setResource(new FileSystemResource("C:\\Develop\\Project\\goodTeam.zip_expanded\\goodTeam\\src\\main\\resources/users.csv"));
//        flatFileItemReader.setLinesToSkip(1);
//        flatFileItemReader.setLineMapper(lineMapper());
//        return flatFileItemReader;
//    }
//
//    /**
//     * CSV data 轉成 Map<MyUser>
//     * @return
//     */
//    @Bean
//    public LineMapper<MyUser> lineMapper() {
//
//        DefaultLineMapper<MyUser> defaultLineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setStrict(false);
//        lineTokenizer.setNames("id", "name", "dept", "salary");
//
//        BeanWrapperFieldSetMapper<MyUser> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(MyUser.class);
//
//        defaultLineMapper.setLineTokenizer(lineTokenizer);
//        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
//
//        return defaultLineMapper;
//    }
}
