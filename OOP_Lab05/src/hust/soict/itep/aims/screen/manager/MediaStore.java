package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
        this.media=media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost=new JLabel(""+media.getCost()+"$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        if(media instanceof Playable)
        {
            JButton playButton = new JButton("Play");
            container.add(playButton);
            playButton.addActionListener(e -> {

                    showPlayDialog();

            });
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
    private void showPlayDialog() {
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Playing " + media.getTitle());

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Playing " + media.getTitle());
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(messageLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> playDialog.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        playDialog.setContentPane(contentPane);
        playDialog.setSize(300, 150);
        playDialog.setLocationRelativeTo(this);
        playDialog.setModal(true);
        playDialog.setVisible(true);
    }


}