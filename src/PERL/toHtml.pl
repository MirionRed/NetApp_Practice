use LWP::UserAgent;
use HTTP::Request;
use HTTP::Response;
use JSON;
use Text::CSV::Slurp;
use Data::Dumper;

my $ua = new LWP::UserAgent;
$ua->agent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36");
my $url = "http://labs.jamesooi.com/ueen3433-asg.php";
my $request = new HTTP::Request('GET', $url);
my $response = $ua->request($request);

if($response->is_success){
  my $rows = JSON->new->utf8->decode($response->content);
  open $fh, ">:encoding(utf8)", "list.html";
  print $fh "<!DOCTYPE html>";
  print $fh "<html><body>";
  print $fh '<table border = "1">';

  foreach my $row(@$rows){
    print $fh "<tr>";
    foreach my $key (sort keys %$row){
      print $fh "<td>".%row{$key}."</td>";
    }
    print $fh "</tr>";
  }
  print $fh "</table>";
  print $fh "</body></html>";
  close $fh;
} else {
  print $response->error;
}
